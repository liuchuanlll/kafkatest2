package mytest;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2022/11/21 10:25
 * @Description
 */
public class Singleton2 {

    private static volatile Singleton2 singleton2;//Ϊɶ��volatile
    private Singleton2() {}
    public static Singleton2 getInstantce() {
        if(singleton2 == null){
            synchronized(Singleton2.class) {
                if(singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }
        }
            return singleton2;
    }

    public static void main(String[] args) {
        Singleton2 s= Singleton2.getInstantce();
        Singleton2 s2= Singleton2.getInstantce();
        System.out.println(s.equals(s2));
    }
}
//����˼·������ģʽ����Ҫ���ܱ��ⲿʵ���������Թ��췽��˽�С�ֻ��ͨ�����ڲ��������ã�
// ��Ȼ�����޷���ʵ��������ͨ�������޷����ʣ���ô��ֻ��ͨ����̬����ȥ���ã��������ǵ�ʵ��ֻ��һ�����Ϳ��԰��ڲ���ʵ��Ҳ���óɾ�̬�����㾲̬����ȥ����

//�̰߳�ȫ�Ļ���Ҫ��singleton == nullǰ��syn�ؼ��֡��������Ǽ�����Ŀ��ֻ��Ϊ���״α�����ʱ�̲߳���ȫ
// ���˹ؼ����ֻᵼ��ÿ�η��ʸõ������󶼻ᱻ���������ͳ���Ч�ʡ���������ǰ�ټ�һ���жϣ���������ʹ��