package study10_3;

public class IPTV extends ColorTV{
	private String address;

	IPTV(String address,int size, int resolutionWidth,int resolutionHeight){
		super(size,resolutionWidth,resolutionHeight);
		this.address =address;
	}
	void printProperty(){
		System.out.printf("해당 ip: %s tv %d인치 해상도: %d x %d (픽셀 단위) \n",address,getSize(),getResolutionWidth(),getResolutionHeight());
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
}
