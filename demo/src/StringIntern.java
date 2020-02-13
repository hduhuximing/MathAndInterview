public class StringIntern {
    public static void main(String[] args) {
        //将创建 1 或 2 个字符串。如果池中已存在字符串常量“abc”，
        // 则只会在堆空间创建一个字符串常量“abc”。如果池中没有字符串常量“abc”，
        // 那么它将首先在池中创建，然后在堆空间中创建，因此将创建总共 2 个字符串对象。
//        String s1 = new String("计算机");
//        String s2 = s1.intern();
//        String s3 = "计算机";
//        System.out.println(s2);//计算机
//        System.out.println(s1 == s2);//false，因为一个是堆内存中的 String 对象一个是常量池中的 String 对象，
//        System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象
//        System.out.println(s1==s3);

//如果不是用双引号声明的 String 对象，
// 可以使用 String 提供的 intern 方法。
// String.intern() 是一个 Native 方法，
// 它的作用是：
// 如果运行时常量池中已经包含一个等于此 String 对象内容的字符串，
// 则返回常量池中该字符串的引用；
// 如果没有，JDK1.7之前（不包含1.7）的处理方式是在常量池中创建与此 String 内容相同的字符串，
// 并返回常量池中创建的字符串的引用，
// JDK1.7以及之后的处理方式是在常量池中记录此字符串的引用，并返回该引用
        String s = new String("a") + new String("b");
//        String x = "ab";
        String s2 = s.intern();
        String x = "ab";
//        String x="ab";
        System.out.println(s2 == x);
        System.out.println(s == x);
    }
}

