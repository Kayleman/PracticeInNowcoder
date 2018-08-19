package train;

public class TiHuanKongGe {
    public static void main(String[] args) {
        TiHuanKongGe rp = new TiHuanKongGe();
        StringBuffer sb = new StringBuffer("We Are Happy.");
        System.out.println(rp.replaceSpace(sb));

    }

    public String replaceSpace(StringBuffer str) {
        String string = str.toString().replace(" ", "%20");
        return string;
    }
}
