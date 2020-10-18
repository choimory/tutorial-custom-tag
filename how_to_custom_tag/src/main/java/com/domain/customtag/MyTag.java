package com.domain.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTag extends TagSupport {
	private static final long serialVersionUID = 7067374872046045735L;
	
	private String param;
	private String result;	
	
	public void setParam(String param) {
		this.param = param;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.setAttribute(this.result, String.format("param is [%s]", param));
		}catch(Exception e) {
			
		}
		return SKIP_BODY;
	}

}
