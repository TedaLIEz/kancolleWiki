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
        Pattern p = Pattern.compile("[wmd]");
        if (lhs.getId().contains("W") && rhs.getId().contains("W")) {
            int lid = Integer.parseInt(lhs.getId().substring(2, lhs.getId().length()));
            int rid = Integer.parseInt(rhs.getId().substring(2, rhs.getId().length()));
            return lid - rid;
        } else if (lhs.getId().contains("W") && (!rhs.getId().contains("W"))) {
            if (rhs.getId().contains("w") || rhs.getId().contains("m") || rhs.getId().contains("d")) {
                return -1;
            } else {
                return 1;
            }
        } else if ((!lhs.getId().contains("W")) && rhs.getId().contains("W")) {
            if (lhs.getId().contains("w") || lhs.getId().contains("m") || lhs.getId().contains("d")) {
                return -1;
            } else {
                return 1;
            }
        } else {
            String lid = lhs.getId().substring(1, lhs.getId().length());
            String rid = rhs.getId().substring(1, rhs.getId().length());
            Matcher matcher = p.matcher(lid);
            Matcher matcher1 = p.matcher(rid);
            if (matcher.matches() && matcher1.matches()) {
                return -(lid.charAt(0) - rid.charAt(0));
            } else if (matcher.matches() && !matcher1.matches()) {
                return 1;
            } else if (!matcher.matches() && matcher1.matches()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
