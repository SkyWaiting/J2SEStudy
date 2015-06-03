package com.skywaiting.reference;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 2015/6/3
 * Time: 16:47
 */
public class RefTestObj {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return super.toString() + "[id=" + this.id + "]";
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object [" + this.hashCode() + "][id=" + this.id +"] come into finalize");

        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
