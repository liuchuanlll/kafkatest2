package thread;
class Message{
    private boolean flag=false;
    private String name;
    private String title;

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getTitle() {
        return title;
    }
}
class Producer implements Runnable{
    Message message;
    public Producer(Message message){
        this.message=message;
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            synchronized (message){
                if(message.isFlag()){
                    try {
                        message.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(i%2==0){
                    message.setName("王建 ");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    message.setTitle("大帅哥");
                }else{
                    message.setName("小高 ");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    message.setTitle("猥琐第一人");
                }

                message.setFlag(true);
                message.notify();
            }
        }

    }
}
class Consumer implements Runnable{
    Message message;
    public Consumer(Message message){
        this.message=message;
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            synchronized (message){
                if(!message.isFlag()){
                    try {
                        message.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(message.getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(message.getTitle());

                message.setFlag(false);
                message.notify();
            }

        }


    }
}
public class producerandconsumer01 {
    public static void main(String[] args) {
        Message message=new Message();
        Thread a=new Thread(new Producer(message));
        Thread b=new Thread(new Consumer(message));
        a.start();
        b.start();
    }

}
