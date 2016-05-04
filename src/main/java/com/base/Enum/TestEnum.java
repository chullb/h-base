package com.base.Enum;

/**
 * Created with h-sm.
 * User: xing
 * Date: 2016/5/3
 * Time: 21:07
 * To change this template use File | Settings | File Templates.
 */
//枚举
public class TestEnum {
    /**
     * 普通枚举
     */
    public enum ColorEnum{
        red, green, yellow, blue;
    }
    /**
     * 枚举像普通的类一样可以添加属性和方法，可以为它添加静态和非静态的属性或方法
     *
     * @author jiqinlin
     *
     */
    public enum SeasonEnum {
        //注：枚举写在最前面，否则编译出错
        spring, summer, autumn, winter;

        private final static String position = "test";

        public static SeasonEnum getSeason() {
            if ("test".equals(position))
                return spring;
            else
                return winter;
        }
    }

    /**
     * 性别
     *
     * 实现带有构造器的枚举
     *
     * @author jiqinlin
     *
     */
    public enum Gender{
        //通过括号赋值,而且必须带有一个参构造器和一个属性跟方法，否则编译出错
        //赋值必须都赋值或都不赋值，不能一部分赋值一部分不赋值；如果不赋值则不能写构造器，赋值编译也出错
        MAN("MAN"), WOMEN("WOMEN");

        private final String value;

        //构造器默认也只能是private, 从而保证构造函数只能在内部使用
        Gender(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 订单状态
     *
     * 实现带有抽象方法的枚举
     *
     * @author jiqinlin
     *
     */
    public enum OrderState {
        /** 已取消 */
        CANCEL {public String getName(){return "已取消";}},
        /** 待审核 */
        WAITCONFIRM {public String getName(){return "待审核";}},
        /** 等待付款 */
        WAITPAYMENT {public String getName(){return "等待付款";}},
        /** 正在配货 */
        ADMEASUREPRODUCT {public String getName(){return "正在配货";}},
        /** 等待发货 */
        WAITDELIVER {public String getName(){return "等待发货";}},
        /** 已发货 */
        DELIVERED {public String getName(){return "已发货";}},
        /** 已收货 */
        RECEIVED {public String getName(){return "已收货";}};

        public abstract String getName();
    }

    public static enum ReturnResult
    {
        CM_PARAMETER_ISNULL(1, "参数为空"),
        CM_NULL_DATA(2, "没有找到相关的数据"),
        CM_PARAMETER_WRONG(3, "参数错误，请核查"),
        CM_REQUEST_ERROR(4, "不允许请求查询非当前用户的数据"),
        CM_SUCCESS(200, "成功"),
        CM_INTF_NOTEXSITS(404, "接口不存在"),
        CM_WRONG_TOKEN(403, "签名验证不通过，拒绝访问"),
        CM_FAIL(500, "服务端异常"),
        CM_CANNOTMARKING(501, "无权限阅此题"),
        CM_MARKINGFINISH(502, "阅卷任务队列已经全部分配完"),
        CM_MARKINGTIMOUT(503, "阅卷超时"),
        CM_NOTFINDQUESTION(504, "没有找到获取试题记录"),
        CM_TASKLOADING(505, "阅卷任务正在加载中"),
        CM_TASK_MARKING_WAIT(506 , "暂无可阅试题，请稍后再试");


        public static ReturnResult getResult(long typeId) throws Exception
        {
            switch ((int)typeId) {

                default:
                    throw new Exception("无法识别的消费类别定义");
            }
        }

        private int vaule;
        private String info;

        private ReturnResult(int value, String info) {
            this.vaule = value;
            this.info = info;
        }

        public int getValue() {
            return vaule;
        }

        public String getInfo() {
            return info;
        }
    }

    public static void main(String[] args) {
        //枚举是一种类型，用于定义变量，以限制变量的赋值；赋值时通过“枚举名.值”取得枚举中的值
        ColorEnum colorEnum = ColorEnum.blue;
        switch (colorEnum) {
            case red:
                System.out.println("color is red");
                break;
            case green:
                System.out.println("color is green");
                break;
            case yellow:
                System.out.println("color is yellow");
                break;
            case blue:
                System.out.println("color is blue");
                break;
        }

        //遍历枚举
        System.out.println("遍历ColorEnum枚举中的值");
        for(ColorEnum color : ColorEnum.values()){
            System.out.println(color);
        }

        //获取枚举的个数
        System.out.println("ColorEnum枚举中的值有"+ColorEnum.values().length+"个");

        //获取枚举的索引位置，默认从0开始
        System.out.println(ColorEnum.red.ordinal());//0
        System.out.println(ColorEnum.green.ordinal());//1
        System.out.println(ColorEnum.yellow.ordinal());//2
        System.out.println(ColorEnum.blue.ordinal());//3

        //枚举默认实现了java.lang.Comparable接口
        System.out.println(ColorEnum.red.compareTo(ColorEnum.green));//-1

        //--------------------------
        System.out.println("===========");
        System.err.println("季节为" + SeasonEnum.getSeason());


        //--------------
        System.out.println("===========");
        for(Gender gender : Gender.values()){
            System.out.println(gender.value);
        }

        //--------------
        System.out.println("===========");
        for(OrderState order : OrderState.values()){
            System.out.println(order.getName());
        }
    }

    /**
     * 枚举是一种规范它规范了参数的形式，这样就可以不用考虑类型的不匹配并且显式的替代了int型参数可能带来的模糊概念 枚举像一个类，又像一个数组。

     Enum作为Sun全新引进的一个关键字，看起来很象是特殊的class, 它也可以有自己的变量，可以定义自己的方法，可以实现一个或者多个接口。 当我们在声明一个enum类型时，我们应该注意到enum类型有如下的一些特征。

     1．它不能有public的构造函数，这样做可以保证客户代码没有办法新建一个enum的实例。

     2．所有枚举值都是public , static , final的。注意这一点只是针对于枚举值，我们可以和在普通类里面定义 变量一样定义其它任何类型的非枚举变量，这些变量可以用任何你想用的修饰符。

     3．Enum默认实现了java.lang.Comparable接口。

     4．Enum覆载了了toString方法，因此我们如果调用Color.Blue.toString()默认返回字符串”Blue”.

     5．Enum提供了一个valueOf方法，这个方法和toString方法是相对应的。调用valueOf(“Blue”)将返回Color.Blue.因此我们在自己重写toString方法的时候就要注意到这一点，一把来说应该相对应地重写valueOf方法。

     6．Enum还提供了values方法，这个方法使你能够方便的遍历所有的枚举值。

     7．Enum还有一个oridinal的方法，这个方法返回枚举值在枚举类种的顺序，这个顺序根据枚举值声明的顺序而定，这里Color.Red.ordinal()返回0。

     了解了这些基本特性，我们来看看如何使用它们。
     */
}
