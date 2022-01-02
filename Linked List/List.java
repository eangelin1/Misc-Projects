class List {
    Node head;
    Node tail;

    List()
    {
        head = tail = new Node();
        head.next = tail;
    }
    
    List(final List list)
    {
        head = tail = new Node();
        head.next = tail;

        Node iter1 = head,
             iter2 = list.head.next;

        for(; iter2 != list.tail; iter2 = iter2.next)
        {
            Node tmp = new Node(String.valueOf(iter2.name));
            iter1.next = tmp;
            tmp.next = tail;
            iter1 = iter1.next;
        }
    }

    void append(final String name)
    {
        Node tmp = new Node(name);

        if(head.next.next == null)
        {
            head.next = tmp;
        }
        
        tmp.next = tail;

        Node iter = head;

        while(iter.next != tail)
        {
            iter = iter.next;
        }

        iter.next = tmp;

        return;
    }

    String delete()
    {
        Node del_node = head.next;
        char[] del_str = del_node.name;
        head.next = del_node.next;

        return String.valueOf(del_str);
    }

    void print()
    {
        for(Node iter = head.next; iter != tail; iter=iter.next)
        {
            System.out.println(iter.name);
        }
    }

    boolean changeName(final String newName, final int index)
    {
        Node iter = head;

        for(int i = 0; i < index; i++)
        {
            iter = iter.next;
            if(iter == tail)
            {
                return false;
            }
        }

        iter.name = newName.toCharArray();
        return true;
    }
}
