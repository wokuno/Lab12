/*
    Meghana Woodruff    wood143
    William Okuno       Okuno006
    lab 12
*/
public class CallTree {

    private CallTreeNode root = null;

    public CallTree (String name){
        this.root = new CallTreeNode(name, null, null);
    }

    private CallTreeNode find(String name, CallTreeNode node){
        if (node.getName() == name){
            return node;
        }
        if (node.isCaller()){
            CallTreeNode n1 = null;
            if (node.getSecond() != null && n1 == null){
                n1 = find(name, node.getSecond());
            }
            if (node.getFirst() != null && n1 == null){
                n1 = find(name, node.getFirst());
            }
            return n1;
        } else {
            return null;
        }
    }

    private CallTreeNode find(String name){
        return find(name, this.root);
    }

    public boolean inCallTree(String person){
        CallTreeNode temp = find(person);
        if (temp != null){
            return true;
        }
        return false;
    }

    public boolean shouldCall(String person, String first, String second){
        CallTreeNode temp = find(person);
        if (temp == null) {
            return false;
        }
        if (temp.isCaller()){
            return false;
        }
        if (inCallTree(first) || inCallTree(second)){
            return false;
        }

        temp.setFirst(new CallTreeNode(first, null, null));
        temp.setSecond(new CallTreeNode(second, null, null));
        return true;
    }

    public String getFirstCall(String name){
        CallTreeNode temp = find(name);
        if (temp == null) {
            return null;
        }
        if (temp.isCaller() && temp.getFirst() != null){
                return temp.getFirst().getName();
            }
        return null;
    }

    public String getSecondCall(String name){
        CallTreeNode temp = find(name);
        if (temp == null) {
            return null;
        }
        if (temp.isCaller() && temp.getSecond() != null){
            return temp.getSecond().getName();
        }
        return null;
    }

    public boolean wouldBeContacted(String caller, String receiver){
        CallTreeNode temp = find(caller);
        if (temp == null){
            return false;
        }
        CallTreeNode temp2 = find(receiver, temp);
        if (temp2 != null){
            return true;
        }
        return false;
    }

    private int getSize(CallTreeNode node) {
        if (node == null){
            return 0;
        }
        int sum = 1;
        if (node.isCaller()){
            if (node.getSecond() != null){
                sum += getSize(node.getSecond());
            }
            if (node.getFirst() != null){
                sum += getSize(node.getFirst());
            }
        }
        return sum;
    }

    public int getContactCount(String name){
        return getSize(find(name));
    }

    public int getCallTreeSize(){
        return getSize(this.root);
    }
}