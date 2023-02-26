package study10_3;

public class ColorTV extends TV{
	private int size;
	private int resolutionWidth; //가로 픽셀?
	private int resolutionHeight;//세로 픽셀?

	ColorTV(int size, int resolutionWidth,int resolutionHeight){
		super(size);
		this.size =size;
		this.resolutionWidth=resolutionWidth;
		this.resolutionHeight=resolutionHeight;
	}
	void printProperty() {
		System.out.printf("해당 tv %d인치 해상도: %d x %d (픽셀 단위) \n",size,resolutionWidth,resolutionHeight);
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getResolutionWidth() {
		return resolutionWidth;
	}
	public void setResolutionWidth(int resolutionWidth) {
		this.resolutionWidth = resolutionWidth;
	}
	public int getResolutionHeight() {
		return resolutionHeight;
	}
	public void setResolutionHeight(int resolutionHeight) {
		this.resolutionHeight = resolutionHeight;
	}

}
