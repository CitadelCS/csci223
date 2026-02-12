"""
Disable AI tools before starting homework.
This assignment is individual work. You may not use CoPilot, JetBrains AI,
or any other AI code generation tool to help you with this assignment.
You may ask for help from the instructor or TAs, but you must write the code yourself.

CWID:
Honor Code: I have neither given nor received unauthorized aid on this assignment,
and I have followed the academic honor code as specified in the syllabus.
Type your name -->

Instructions: Implement the missing methods. To test them, you can add a main function that
creates a LinkedList, adds some items, and calls the methods to see if they return the
expected results. You can also use the __str__ method to print the list and visually verify its contents.

Hints: Study the given methods and draw diagrams for the ones you must write. Consider
corner cases as well, such as when the list is empty or has only one item. You may find it helpful to use
helper methods, such as _getNode, to avoid repeating code.

If you prefer Java, a Java version of this starter code is available.

"""

class LinkedList:
    class _Node:
        def __init__(self, item, next=None):
            self.item = item
            self.next = next

    class _FancyIterator:
        def __init__(self, start_node):
            self.next_node = start_node

        def __iter__(self):
            return self

        def __next__(self):
            if self.next_node is None:
                raise StopIteration
            save = self.next_node
            self.next_node = self.next_node.next
            return save.item

    def __init__(self):
        self.size = 0
        self.first = None

    def is_empty(self):
        return self.first is None

    def size_(self):
        return self.size

    # make the list iterable
    def __iter__(self):
        return self._FancyIterator(self.first)

    def __str__(self):
        return "".join(f"{item}\n" for item in self)

    # add to beginning
    def add(self, item):
        self.first = self._Node(item, self.first)
        self.size += 1

    # remove from beginning
    def remove(self):
        if self.is_empty():
            return None
        doomed = self.first.item
        self.first = self.first.next
        self.size -= 1
        return doomed

    def _get_node(self, item):
        curr = self.first
        while curr is not None:
            if curr.item == item:
                return curr
            curr = curr.next
        return None

    # Return zero-based index of item, or -1 if not found
    def index_of(self, item):
        loc = 0
        curr = self.first
        while curr is not None:
            if curr.item == item:
                return loc
            curr = curr.next
            loc += 1
        return -1

    # Return item immediately after given item
    def after(self, item):
        pass #delete this line
        # TODO: implement





    # Return item immediately before given item
    def before(self, item):
        pass #delete this line
        # TODO: implement




    # add at index i
    def add_at(self, i, item):
        # TODO: implement
        pass #delete this line







    # add to end
    def add_last(self, item):
        if self.size == 0:
            self.add(item)
            return
        curr = self.first
        while curr.next is not None:
            curr = curr.next
        curr.next = self._Node(item)
        self.size += 1









    # remove node immediately before item
    def remove_before(self, item):
        if self.size < 2 or self.first.item == item:
            return None

        prev = self.first
        curr = self.first.next

        if curr.item == item:
            self.first = curr
            self.size -= 1
            return prev.item

        lead = curr.next
        while lead is not None:
            if lead.item == item:
                prev.next = lead
                self.size -= 1
                return curr.item
            prev, curr, lead = curr, lead, lead.next

        return None

    # remove node immediately after item
    def remove_after(self, item):
        curr = self._get_node(item)
        if curr is None or curr.next is None:
            return None
        save = curr.next.item
        curr.next = curr.next.next
        self.size -= 1
        return save


