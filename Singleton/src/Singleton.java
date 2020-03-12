class Singleton {

    private static Singleton instance;

    //将构造函数私有化,确保无法被实例化
    private Singleton(){}

    //当有必要的时候，返回实例
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    //获取测试信息
    public void getMessage(){
        System.out.println("单例模式");
    }
}
