package cn.hsiaopan.demo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
    Object notify() 方法用于唤醒一个在此对象监视器上等待的线程
    一个线程要想成为对象监视器的所有者，可以使用以下3种方法：
        执行对象的同步实例方法
        使用synchronized 内置锁
        对于Class 类性的对象，执行同步静态方法
    如果当前线程不是此对象监视器的所有者的话会抛出 IllegalMonitorStateException 异常
 */
public class NotifyDemo {

    private List syncedList;

    public static void main(String[] args) throws InterruptedException {
        final NotifyDemo notifyDemo = new NotifyDemo();

        Runnable runA;
        Runnable runB;

        runA = () -> {
            try {
                String item = notifyDemo.removeElement();
                System.out.println("" + item);
            } catch (InterruptedException ie) {
                System.out.println("Interrupted Exception!");
            } catch (Exception e) {
                System.out.println("Exception Thrown.");
            }
        };


        runB = () -> notifyDemo.addElement("Hello!");

        Thread threadA1 = new Thread(runA, "Google");
        threadA1.start();

        Thread.sleep(500);

        Thread threadA2 = new Thread(runA,"Bing");
        threadA2.start();

        Thread.sleep(500);

        Thread threadB = new Thread(runB,"Tencent");
        threadB.start();

        Thread.sleep(1000);

        threadA1.interrupt();
        threadA2.interrupt();

    }

    public NotifyDemo() {
        // 创建一个同步列表
        syncedList = Collections.synchronizedList(new LinkedList());
    }

    // 删除列表中的元素
    public String removeElement() throws InterruptedException {
        synchronized (syncedList) {

            // 列表为空就等待
            while (syncedList.isEmpty()) {
                System.out.println("List is empty...");
                syncedList.wait();
                System.out.println("Waiting...");
            }
            return (String) syncedList.remove(0);
        }
    }

    // 添加元素到列表
    public void addElement(String element) {
        System.out.println("Opening...");
        synchronized (syncedList) {

            // 添加一个元素，并通知元素已经存在
            syncedList.add(element);
            System.out.println("New Element: '" + element + "'");

            syncedList.notifyAll();
            System.out.println("NotifyAll called!");
        }
        System.out.println("Closing...");
    }

}
