package Page;
public class Page {
    private long totalContentsCount = 0;
    private long pageCount = 10;
    private long displayedNaviBlock = 10;
    public Page(long totalCount){
        this.totalContentsCount = totalCount;
    }
    public String html(long pageIndex) {
        StringBuffer html = new StringBuffer();
        long totalPage = 0;
        long totalRange = 0;
        long currentRange = 0;
        long startPage = 0;
        long endPage = 0;
        try{
            totalPage = this.getTotalPage(totalContentsCount, pageCount);
            pageIndex = this.validatePageIndex(pageIndex, totalPage);
            totalRange = this.getTotalRange(totalPage, displayedNaviBlock);
            currentRange = this.getCurrentRange(pageIndex, displayedNaviBlock);
            startPage = this.getStartPage(currentRange, pageCount);
            endPage = this.getEndPage(currentRange, totalRange, pageCount, displayedNaviBlock, totalPage);
            html.append("<a href='#'>[처음]</a> ").append(System.lineSeparator())
                    .append("<a href='#'>[이전]</a> ").append(System.lineSeparator())
                    .append(System.lineSeparator());

            for (long i = startPage; i <= endPage; i++) {

                if (pageIndex == i) {
                    html.append("<a href='#' class='on' >" + i + "</a>").append(System.lineSeparator());
                } else {
                    html.append("<a href='#' >" + i + "</a>").append(System.lineSeparator());
                }

            }

            html.append(System.lineSeparator())
                    .append("<a href='#'>[다음]</a> ").append(System.lineSeparator())
                    .append("<a href='#'>[마지막]</a> ").append(System.lineSeparator())
                    .append(System.lineSeparator());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return html.toString();
    }

    public long getTotalPage(long totalContentsCount, long pageCount) {

        long totalPage;

        if(totalContentsCount%pageCount == 0){
            totalPage = totalContentsCount/pageCount;
        }else{
            totalPage = (totalContentsCount/pageCount) + 1;
        }
        if(totalPage == 0){
            totalPage = 1;
        }
        return totalPage;
    }
    private long validatePageIndex(long pageIndex, long totalPage) {

        if(pageIndex < 1){
            pageIndex = 1;
        }else if (pageIndex > totalPage){
            pageIndex = totalPage;
        }
        return pageIndex;
    }
    public long getTotalRange(long totalPage, long displayedNaviBlock) {

        long totalRange;

        if(totalPage>=displayedNaviBlock){
            if(totalPage % displayedNaviBlock == 0){
                totalRange = totalPage/displayedNaviBlock;
            }else{
                totalRange = (totalPage/displayedNaviBlock) + 1;
            }
        }else{
            totalRange = 1;
        }
        return totalRange;
    }
    public long getCurrentRange(long pageIndex, long displayedNaviBlock) {
        long currentRange;
        if(pageIndex%displayedNaviBlock == 0){
            currentRange = pageIndex/displayedNaviBlock;
        }else{
            currentRange = (pageIndex/displayedNaviBlock) + 1;
        }
        return currentRange;
    }
    public long getStartPage(long currentRange, long pageCount) {

        long startPage;

        startPage = ((currentRange-1) * pageCount) + 1;

        return startPage;
    }
    public long getEndPage(long currentRange, long totalRange, long pageCount, long displayedNaviBlock, long totalPage){

        long endPage;

        if(currentRange < totalRange){
            endPage = ((currentRange-1) * pageCount) + displayedNaviBlock;
        }else{
            endPage = ((currentRange-1) * pageCount) +  (totalPage%displayedNaviBlock);
        }
        return endPage;
    }
}