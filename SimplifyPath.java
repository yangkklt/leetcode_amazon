public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path.isEmpty()) {
            return path;
        }
        List<String> list = new ArrayList<String>();
        String[] elements = path.split("/+");
        
        for (String str : elements) {
            if (str.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else if (!str.equals(".") && !str.isEmpty()) {
                list.add(str);
            }
        }
        
        StringBuilder builder = new StringBuilder();
        if (list.isEmpty()) {
            builder.append("/");
        } else {
            for (String element : list) {
                builder.append("/").append(element);
            }
        }
        
        return builder.toString();
    }
}