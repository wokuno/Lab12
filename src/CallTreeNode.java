/*
    Meghana Woodruff    wood143
    William Okuno       Okuno006
    lab 12
*/
public class CallTreeNode {

    private String name = "";
    private CallTreeNode first = null, second = null;

    public CallTreeNode(String name, CallTreeNode first, CallTreeNode second){
        this.name = name;
        this.first = first;
        this.second = second;
    }

    public String getName() {
        return this.name;
    }

    public CallTreeNode getFirst() {
        return this.first;
    }

    public CallTreeNode getSecond() {
        return this.second;
    }

    public void setFirst(CallTreeNode first) {
        this.first = first;
    }

    public void setSecond(CallTreeNode second) {
        this.second = second;
    }

    public boolean isCaller(){
        if (first != null || second != null){
            return true;
        }
        return false;
    }
}