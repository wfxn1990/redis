package cn.itcast.core;

public class EnumSingletonDemo {
    private EnumSingletonDemo() {
    }

    private enum EnumHolder {
        INSTANCE;
        private EnumSingletonDemo instance;

        EnumHolder() {
            this.instance = new EnumSingletonDemo();
        }

        private EnumSingletonDemo getInstance() {
            return instance;
        }
    }

    public static EnumSingletonDemo getInstance() {
        return EnumHolder.INSTANCE.instance;
    }
}
