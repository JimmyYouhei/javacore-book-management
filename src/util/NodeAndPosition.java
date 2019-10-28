package util;


public class NodeAndPosition<T> {
    private Node<T> node;
    private int position;

    public NodeAndPosition() {
    }

    public NodeAndPosition(Node<T> node, int position) {
        this.node = node;
        this.position = position;
    }
    public Node<T> getNode() {
        return node;
    }

    public void setNode(Node<T> node) {
        this.node = node;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    public NodeAndPosition<T> travelNextNode(){

        this.setNode(this.getNode().getNext());
        this.setPosition(this.getPosition() + 1);
        return this;
    }




}
