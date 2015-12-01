package cn.syiyi.com.font;

/**
 * font...........
 * cn.syiyi.com.font...........
 * Created by lintao.song on 2015/12/1.
 */
public class Bean {
    private String name;
    private String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Bean(String name, String size) {
        this.name = name;
        this.size = size;
    }
}
