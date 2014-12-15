package org.jesus.meslap.worship.service;


import java.util.List;

import org.jesus.meslap.entity.Worship;

public interface WorshipService {

	public void write(String path, Worship worship);
	public List<Worship> getWorships(Integer fRow, Integer pageSize);
	public Integer getWorshipCount();
	public void update(String path, Worship worship);
	public Worship getWorship(Integer id);
	public void delete(String path, Integer id);
	public Worship getRecentWorship();
	public void importExcelToDB(String path, String fileName);
	public Integer getRecentWorshipId();
	public List<String> getCateogrys();
}
