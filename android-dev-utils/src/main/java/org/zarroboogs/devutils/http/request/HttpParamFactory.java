package org.zarroboogs.devutils.http.request;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.entity.FileEntity;

public class HttpParamFactory {

	public static HttpEntity createBasicEntity(){
		HttpEntryList httpEntryList = new HttpEntryList();
		return httpEntryList.build();
	}
	
	public static HttpEntity createFileHttpEntity(File uploadFile){
		FileEntity reqEntity = new FileEntity(uploadFile, HttpConstances.CONTENT_TYPE_OCTET_STREAM);
		return reqEntity;
	}
}
