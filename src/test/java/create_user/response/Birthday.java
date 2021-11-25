
package create_user.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Birthday {

    @Expose
    private Long sec;
    @Expose
    private Long usec;

    public Long getSec() {
        return sec;
    }

    public void setSec(Long sec) {
        this.sec = sec;
    }

    public Long getUsec() {
        return usec;
    }

    public void setUsec(Long usec) {
        this.usec = usec;
    }

}
