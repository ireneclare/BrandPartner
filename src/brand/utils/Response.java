package brand.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Response implements Serializable {

	private static final long serialVersionUID = -3112258229025554224L;

	private boolean response;
	private String error;
	private String status;
	private String msg;
	private int code;
	
	private Map<String, Object> data;
	
	public Response()
	{
		this.setMsg("Successfully processed!");
		this.setStatus("success");
		this.setError("no error");
		this.setCode(200);
		this.setResponse(true);
	}

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		
		if(data == null)
			data						=	new LinkedHashMap<String, Object>();
		
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void add(String key, Object obj) {
		
		if (data == null)
			data			=	new HashMap<>();
			
		data.put(key, obj);
	}
	
	/** -------------------------------- */
	
	public Response change(int code, Response resp, String msg)
	{
		if(code == 200)
		{
			if(msg != null)
				resp.setMsg(msg);
		}
		else if(code == 500)
		{
			if(msg == null)
				msg				=	"Invalid data";
			
			resp.setMsg(msg);
			resp.setStatus("failure");
			resp.setError("Internal server error!");
			resp.setCode(500);
			resp.setResponse(false);
		}
		
		return resp;
	}
}
