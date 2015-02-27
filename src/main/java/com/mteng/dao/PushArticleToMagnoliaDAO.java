package com.mteng.dao;

import java.util.HashMap;

public interface PushArticleToMagnoliaDAO {
	public HashMap<String, String> getContentBasedonDocID(String inputKeyword);
}
