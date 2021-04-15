package cn.hsiaopan.demo;

public enum Color {
    RED {
        public String getColor(){ // 枚举对象实现抽象方法
            return "红色";
        }
    },
    GREEN{
        public String getColor(){
            return "绿色";
        }
    },
    BLUE{
        public String getColor(){
            return "蓝色";
        }
    };

    private Color(){
        System.out.println("Constructor \"" + this.getColor() + "\" called for: " + this.toString());
    }

    public abstract String getColor();

    public void colorInfo(){
        System.out.println("Universal Color");
    }
}

class MyTest{
    public static void main(String[] args) {
        Color c = Color.RED;
        System.out.println(c + " " + c.getColor());
        c.colorInfo();
    }
}
