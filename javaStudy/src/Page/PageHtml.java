package Page;

//공승환 작성
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class PageHtml {
  public static void main(String[] args) {
      long totalCount = 127;
      long pageIndex = 1;
      Page page = new Page(totalCount);
      StringBuffer html = new StringBuffer();
      html.append("<head>")
              .append("<meta charset='UTF-8'/>")
              .append("<style>")
              .append(".on { font-weight:bold; color:red; }")
              .append("</style>")
              .append("</head>")
              .append("<body>");
      for(;pageIndex<=13;pageIndex++){
          html.append(page.html(pageIndex));
          html.append("<br>");
          }
          html.append("</body>");
      try {
          File file = new File("src/Page/file/pageNavi.html");
          if (!file.exists())file.createNewFile();
          BufferedWriter write = new BufferedWriter(new FileWriter(file));
          write.write(html.toString());
          write.close();
      } catch (IOException e) {
          e.printStackTrace();
      }//html 파일 생성 소스코드(안에 html형식으로 StringBuffer를 생성하여 파일에 입력하는 형태)
  }
}