class Node
{
    char[] name;
    Node next;

    Node()
    {
        name = null;
        next = null;
    }

    Node(final String str)
    {
        name = str.toCharArray();
        next = null;
    }

    Node(final Node node)
    {
        name = node.name;
        next = node.next;
    }
}