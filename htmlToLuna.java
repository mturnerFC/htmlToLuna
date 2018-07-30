ArrayList<String> tags;
StringBuilder sb;
Iterator<String> it;
String htmlToLuna(String html) {
    tags = new ArrayList<>(); 
    int offset = 0;
//    html = html.trim().replaceAll(">\\s+<", "><");
    while (offset < html.length()) {
        if (html.startsWith("<p>", offset)) {
            offset+=3;
            tags.add("<p>");
        } else if (html.startsWith("</p>", offset)) {
            offset+=4;
            tags.add("</p>");
        } else if (html.startsWith("<b>", offset)) {
            offset+=3;
            tags.add("<b>");
        } else if (html.startsWith("</b>", offset)) {
            offset+=4;
            tags.add("</b>");
        } else if (html.startsWith("<div>", offset)) {
            offset+=5;
            tags.add("<div>");
        } else if (html.startsWith("</div>", offset)) {
            offset+=6;
            tags.add("</div>");
        } else if (html.startsWith("<img />", offset)) {
            offset+=7;
            tags.add("<img />");
        }
//        System.out.println("Offset " + offset);
    }
//    int tagStart = html.indexOf("<");
//    while (tagStart != -1) {
//        int tagEnd = html.indexOf(">");
//        String tag = html.substring(tagStart, tagEnd + 1);
////        System.out.println("tag " + tag);
//        tags.add(tag);
//        html = html.replaceFirst(tag,""); 
//        tagStart = html.indexOf("<");
//    }
//    System.out.println("tags " + tags.toString());
    sb = new StringBuilder();
    it = tags.iterator();
    while (it.hasNext()) {
        String firstTag = it.next();
        ProcessTag(firstTag);
    }
//    return sb.toString();
    return new String(sb);
}
void ProcessTag(String tag) {
    if (tag.equals("<img />")) {
        sb.append("IMG({})");
    } else if (tag.equals("<div>")) {
        sb.append("DIV([");
    } else if (tag.equals("<p>")) {
        sb.append("P([");
    } else if (tag.equals("<b>")) {
        sb.append("B([");
    }
    boolean firstTime = true;
    while (it.hasNext()) {
        String prevTag = tag;
        tag = it.next();
        if (tag.startsWith("</")){
            sb.append("])");
            return;
        } else {
            if (!firstTime && !tag.equals("<img />")) {
                sb.append(", ");
            }
            ProcessTag(tag);
            firstTime = false;
        }
    }
}
