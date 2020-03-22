package DesignModule.CompositeModule;

import TypeCheck.A;

import java.util.ArrayList;

public class CompositeDemo {
    public static void main(String[] args) {

    }
}

/**
*
*/
abstract class Component{

    public void doSomething(){

    }
}
class Composite extends Component{
    private ArrayList<Component> arrayList = new ArrayList<Component>();

    private void add (Component component){
        this.arrayList.add(component);
    }

    public void remove(Component component){
        this.arrayList.remove(component);
    }

    public ArrayList<Component> getChildren(){
        return this.arrayList;
    }
}

class Leaf extends Component{

}