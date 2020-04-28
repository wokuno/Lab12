public class CallTreeTests {
    public static void main(String[] args) {
        CallTree ct = new CallTree("Dania");
        CallTree tree = new CallTree("Daniel");
        System.out.println(null == tree.getFirstCall("Dania")); // true
        System.out.println(null == tree.getFirstCall("Daniel")); // true
        System.out.println(tree.inCallTree("Majid")); // false
        System.out.println(tree.inCallTree("Daniel")); // True
        System.out.println(tree.getCallTreeSize()); // 1


        boolean result = tree.shouldCall("Daniel", "HaiWei", "Majid");
        System.out.println(result); // true
        System.out.println(tree.inCallTree("Majid")); // true
        System.out.println(tree.inCallTree("HaiWei")); // true
        System.out.println(tree.getCallTreeSize()); // 3
        System.out.println(tree.getFirstCall("Daniel")); // HaiWei
        System.out.println(tree.getSecondCall("Daniel")); // Majid

        result = tree.shouldCall("Majid", "HaiWei", "Carson");
        System.out.println(result); // false
        System.out.println(tree.getCallTreeSize()); // 3

        result = tree.shouldCall("Majid", "Carson", "Daniel");
        System.out.println(result); // false
        System.out.println(tree.getCallTreeSize()); // 3

        result = tree.shouldCall("Daniel", "Ryan P", "Carson");
        System.out.println(result); // false
        System.out.println(tree.getCallTreeSize()); // 3

        result = tree.shouldCall("Carson", "Ryan P", "Ryan K");
        System.out.println(result); // false
        System.out.println(tree.getCallTreeSize()); // 3

        result = tree.shouldCall("Majid", "Lois", "Cameron");
        System.out.println(result); // true
        System.out.println(tree.getCallTreeSize()); // 5

        result = tree.shouldCall("HaiWei", "Quani", "Carson");
        System.out.println(result); // true
        System.out.println(tree.getCallTreeSize()); // 7

        result = tree.shouldCall("Carson", "Ryan K", "Ryan P");
        System.out.println(result); // true
        System.out.println(tree.getCallTreeSize()); // 9


        System.out.println(tree.getFirstCall("Carson")); // Ryan K
        System.out.println(tree.getSecondCall("HaiWei")); // Carson

        System.out.println(tree.inCallTree("Quani")); // true
        System.out.println(tree.inCallTree("Carson")); // true
        System.out.println(tree.inCallTree("Lois")); // true
        System.out.println(tree.inCallTree("Lily")); // false

        System.out.println(tree.getContactCount("Majid")); // 3
        System.out.println(tree.getContactCount("HaiWei")); // 5

        System.out.println(tree.wouldBeContacted("Daniel", "Lois")); // true
        System.out.println(tree.wouldBeContacted("Lily", "Lois")); // false
        System.out.println(tree.wouldBeContacted("Daniel", "Lily")); // false
        System.out.println(tree.wouldBeContacted("Ryan P", "Ryan K")); // false
    }
}
/*
true
true
false
true
1
true
true
true
3
HaiWei
Majid
false
3
false
3
false
3
false
3
true
5
true
7
true
9
Ryan K
Carson
true
true
true
false
3
5
true
false
false
false
 */
