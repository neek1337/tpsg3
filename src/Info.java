public class Info {
    String method;
    String fileName;
    boolean needHelp;

    public Info() {
        method = "";
        fileName = "input.txt";
        needHelp = false;
    }

    public String getMethod() {
        return method;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isNeedHelp() {
        return needHelp;
    }


    public Info(String[] args) {
        this();
        try {
            for (int i = 0; i < args.length; i++) {
                String[] local = args[i].split(":");
                if (local[0].equals("/m")) {
                    method = local[1];
                } else {

                    if (local[0].equals("/f")) {
                        fileName = local[1];

                    } else {
                        if (args[i].equals("/h")) {
                            needHelp = true;

                        } else {
                            throw new IllegalArgumentException("Введены неверные данные");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            ;
        }

    }


}
