package app.ctf.ctf_academy.api.dto;

public class SubmitReq {
    private String flag;
    private String slug;
    public SubmitReq() {}         
    public SubmitReq(String flag) { this.flag = flag; }
    public String getSlug(){
        return this.slug;
    }
    public String getFlag() { return flag; }
    public void setFlag(String flag) { this.flag = flag; }
}
