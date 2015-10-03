package com.example.kancollewiki.util;

import com.example.kancollewiki.bean.Task;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/10/1.
 */
public class TaskItemComparator implements Comparator<Task>{

    @Override
    public int compare(Task lhs, Task rhs) {
        Pattern p = Pattern.compile("^[wmd]\\S+");
        String o1 = lhs.getId();
        String o2 = rhs.getId();


        if (o1.contains("W") && o2.contains("W")) {
            String l = o1.substring(2, o1.length());
            String r = o2.substring(2, o2.length());
            int lid = Integer.parseInt(l);
            int rid = Integer.parseInt(r);
            return lid - rid;
        }  else if (!o1.contains("W") && !o2.contains("W")){

            String lid = o1.substring(1, o1.length());
            String rid = o2.substring(1, o2.length());
            Matcher matcher = p.matcher(lid);
            Matcher matcher1 = p.matcher(rid);
            if (matcher.matches() && matcher1.matches()) {
                if (lid.charAt(0) == 'd' && rid.charAt(0) == 'w') {
                    return -1;
                } else if (lid.charAt(0) == 'w' && rid.charAt(0) == 'm') {
                    return -1;
                } else if (lid.charAt(0) == 'm' && rid.charAt(0) == 'w') {
                    return 1;
                } else if (lid.charAt(0) == 'd' && rid.charAt(0) == 'm') {
                    return -1;
                } else if (lid.charAt(0) == 'w' && rid.charAt(0) == 'd') {
                    return -1;
                } else if (lid.charAt(0) == 'm' && rid.charAt(0) == 'd') {
                    return -1;
                } else {
                    return Integer.parseInt(o1.substring(2, o1.length())) - Integer.parseInt(o2.substring(2, o2.length()));
                }
            } else if (matcher.matches() && !matcher1.matches()) {
                return 1;
            } else if (!matcher.matches() && matcher1.matches()) {
                return -1;
            } else {
                if (lid.equals(rid)) {
                    return 0;
                } else if (lid.equals("") && !rid.equals("")) {
                    return 1;
                } else if (!lid.equals("") && rid.equals("")) {
                    return -1;
                } else {
                    return Integer.parseInt(lid) - Integer.parseInt(rid);
                }

            }
        } else if (o1.contains("W") && !o2.contains("W")) {
            if (o2.contains("w")) {
                return -1;
            }
            if (o2.contains("d")) {
                return -1;
            }
            if (o2.contains("m")) {
                return -1;
            }
            return 1;
        } else if ((!o1.contains("W")) && o2.contains("W")) {
            if (o1.contains("w")) {
                return 1;
            }
            if (o1.contains("d")) {
                return 1;
            }
            if (o1.contains("m")) {
                return 1;
            }
            return -1;
        } else {
            return 0;
        }
    }
}
