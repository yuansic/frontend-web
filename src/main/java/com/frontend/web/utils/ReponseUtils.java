package com.frontend.web.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.frontend.web.model.chart.factor.SeriesVo;
import com.frontend.web.model.response.CycleDataSet;
import com.frontend.web.model.response.DataSetRow;
import com.frontend.web.model.response.RepDic;
import com.frontend.web.model.response.RepQuota;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.model.response.RowData;

/**
 * 大数据解析工具类<br>
 * 
 * @author knowAndDo
 *
 */
public class ReponseUtils {
	
	//新增  开户量排名图的seriesData
	public static List<SeriesVo> getSeriesVosAccountByRep(Reponse rdata) {
		List<SeriesVo> seriesvos = new ArrayList<SeriesVo>();
		SeriesVo seriesVo = new SeriesVo();
		seriesVo.setLegendCode(rdata.getQuota().getQuota_name());
		seriesVo.setLegendName(rdata.getQuota().getQuota_name());
		List<String> data = new ArrayList<>();
		List<RepDic> repDics = rdata.getQuota().getDim().getDic();
		for (RepDic repDic : repDics) {
			List<DataSetRow> data_set_rows = repDic.getDic_data_cycle().getCycle_data_set().get(0).getData_set_row();
			if (CollectionUtils.isEmpty(data_set_rows)) {
				data.add("0");
			}else {
				data.add(data_set_rows.get(0).getRow_data().get(0).getData_value());
			}
		}
		seriesVo.setData(data);
		seriesvos.add(seriesVo);
		return seriesvos;
	}
	
	//新增  用户量图的seriesData
	public static List<SeriesVo> getBarTopSeriesVosByRep(Reponse rdata, String cnt) {
		List<SeriesVo> seriesvos = new ArrayList<SeriesVo>();
		SeriesVo seriesVo = new SeriesVo();
		seriesVo.setLegendCode(rdata.getQuota().getQuota_name());
		seriesVo.setLegendName(rdata.getQuota().getQuota_name());
		List<String> data = new ArrayList<>();
		List<DataSetRow> data_set_rows = rdata.getQuota().getDim().getDic().get(0).getDic_data_cycle().getCycle_data_set().get(0).getData_set_row();
		if (!CollectionUtils.isEmpty(data_set_rows)) {
			for (DataSetRow dataSetRow : data_set_rows) {
				List<RowData> row_datas = dataSetRow.getRow_data();
				if (!CollectionUtils.isEmpty(row_datas)) {
					for (RowData rowData : row_datas) {
						if (StringUtils.equals(cnt,rowData.getData_code())) {
							data.add(rowData.getData_value());
							break;
						}
					}
				}
			}
		}
		seriesVo.setData(data);
		seriesvos.add(seriesVo);
		return seriesvos;
	}
	
	//新增  分时图的seriesData
	public static ArrayList<SeriesVo> getSeriesDataByRepDic(RepDic repDic, List<String> x_data) {
		Set<String> legendCode = new LinkedHashSet<String>();
		legendCode.addAll(getCycleValues(repDic.getDic_data_cycle().getCycle_data_set()));//三个日期
		ArrayList<SeriesVo> seriesvos = new ArrayList<SeriesVo>();
		for (String cycle_value : legendCode) {
			List<String> data_values = getdataValuesByCycleValue(cycle_value, repDic, x_data);
			SeriesVo svo = new SeriesVo();
			svo.setLegendCode(cycle_value);
			svo.setLegendName(cycle_value);
			svo.setData(data_values);
			seriesvos.add(svo);
		}
		return seriesvos;
	}

	//新增  分时图seriesData中的每一项
	/**
	 * @param cycle_value
	 * @param repDic
	 * @param x_data
	 * @return
	 */
	private static List<String> getdataValuesByCycleValue(String cycle_value, RepDic repDic, List<String> x_data) {
		List<String> data = new ArrayList<>();
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		for (String key : x_data) {
			map.put(key, "0");
		}
		Set<String> keySet = map.keySet();
		List<CycleDataSet> cycle_data_sets = repDic.getDic_data_cycle().getCycle_data_set();
		String interval = "-1";
		if (!CollectionUtils.isEmpty(cycle_data_sets)) {
			for (CycleDataSet cycleDataSet : cycle_data_sets) {
				//当天数据特殊处理  获取当天最大时间节点interval
				if (cycle_value.equals(new SimpleDateFormat("yyyyMMdd").format(new Date()))) {
					List<DataSetRow> data_set_rows = cycleDataSet.getData_set_row();
					if (CollectionUtils.isEmpty(data_set_rows)) {
						return data;
					}
					if (!CollectionUtils.isEmpty(data_set_rows)) {
						interval = data_set_rows.get(data_set_rows.size()-1).getInterval();
					}
				}
				if (cycle_value.equals(cycleDataSet.getCycle_value())) {
					List<DataSetRow> data_set_rows = cycleDataSet.getData_set_row();
					if (CollectionUtils.isEmpty(data_set_rows)) {
						return data;
					}
					if (!CollectionUtils.isEmpty(data_set_rows)) {
						for (DataSetRow dataSetRow : data_set_rows) {
							if (keySet.contains(dataSetRow.getInterval())) {
								map.put(dataSetRow.getInterval(), dataSetRow.getRow_data().get(0).getData_value());
							}
						}
					}
					break;
				}
			}
		}
		data.addAll(map.values());
		int forLength = data.size();
		if (!"-1".equals(interval)) {
			forLength = x_data.indexOf(interval)+1;
			interval = "-1";
		}
		List<String> data1 = new ArrayList<>(forLength);
		data1.add(data.get(0));
		for (int i = 1; i< forLength; i++) {
			if ("0".equals(data.get(i))) {
				for(int j = i-1; j >= 0; j--){
					String val = data.get(j);
					if (!"0".equals(val)) {
						data1.add(val);
						break;
					}
					if (j == 0) {
						data1.add(val);
						break;
					}
				}
			}else {
				data1.add(data.get(i));
			}
		}
		return data1;
	}


	// TODO 新增
	public static ArrayList<SeriesVo> getBarYSeriesVosByRep(Reponse data) {
		LinkedHashMap<String, LinkedHashMap<String, String>> seriesDataMap = new LinkedHashMap<String, LinkedHashMap<String, String>>(); // 所有的时间坐标
		if (null == data) {
			return null;
		}

		RepQuota quota = data.getQuota();
		if (null == quota) {
			return null;
		}

		List<RepDic> dics = quota.getDim().getDic();

		seriesDataMap = getdataValueByCycleValueAndDicCodeBarY(dics);

		ArrayList<SeriesVo> seriesvos = new ArrayList<SeriesVo>();
		Set<Entry<String, LinkedHashMap<String, String>>> seter = seriesDataMap.entrySet();
		for (Entry<String, LinkedHashMap<String, String>> sets : seter) {
			SeriesVo svo = new SeriesVo();
			svo.setLegendCode(sets.getKey());
			svo.setLegendName(sets.getKey());
			List<String> dataSets = new ArrayList<String>();
			Set<Entry<String, String>> set = sets.getValue().entrySet();
			for (Entry<String, String> entry : set) {
				dataSets.add(entry.getValue());
			}
			svo.setData(dataSets);

			seriesvos.add(svo);
		}

		return seriesvos;
	}

	// TODO
	private static LinkedHashMap<String, LinkedHashMap<String, String>> getdataValueByCycleValueAndDicCodeBarY(
			List<RepDic> dics) {
		LinkedHashMap<String, LinkedHashMap<String, String>> resMap = new LinkedHashMap<>();
		for (RepDic repDic : dics) {
			List<CycleDataSet> cycle_data_set = repDic.getDic_data_cycle().getCycle_data_set();
			for (CycleDataSet cycleDataSet : cycle_data_set) {
				if (cycleDataSet.getData_set_row() != null && cycleDataSet.getData_set_row().size() > 0) {
					for (DataSetRow row : cycleDataSet.getData_set_row()) {
						List<RowData> rowDatas = row.getRow_data();
						if (rowDatas != null && rowDatas.size() > 0) {
							for (RowData rowData : rowDatas) {
								if (resMap.containsKey(rowData.getData_code())) {
									resMap.get(rowData.getData_code()).put(repDic.getDic_code(),
											rowData.getData_value());
								} else {
									LinkedHashMap<String, String> vMap = new LinkedHashMap<>();
									vMap.put(repDic.getDic_code(), rowData.getData_value());
									resMap.put(rowData.getData_code(), vMap);
								}
							}
						}
					}
				}

			}
		}

		return resMap;
	}

	/**
	 * @param seriesData
	 * @param data
	 * @return
	 */
	public static ArrayList<SeriesVo> getBarSeriesVosByRep(Reponse data) {
		LinkedHashMap<String, LinkedHashMap<String, String>> seriesDataMap = new LinkedHashMap<String, LinkedHashMap<String, String>>(); // 所有的时间坐标
		Set<String> legendCode = new LinkedHashSet<String>();

		Set<String> dic_codes = new LinkedHashSet<String>();
		if (null == data) {
			return null;
		}

		RepQuota quota = data.getQuota();
		if (null == quota) {
			return null;
		}

		List<RepDic> dics = quota.getDim().getDic();

		for (RepDic repDic : dics) {
			legendCode.addAll(getCycleValues(repDic.getDic_data_cycle().getCycle_data_set()));
			dic_codes.add(repDic.getDic_code());
		}
		for (String cycle_value : legendCode) {

			LinkedHashMap<String, String> value = new LinkedHashMap<String, String>();
			for (String dic_code : dic_codes) {
				String data_value = getdataValueByCycleValueAndDicCode(cycle_value, dic_code, dics);
				value.put(dic_code,
						StringUtil.isBlank(data_value) ? "0" : "null".equals(data_value) ? "0" : data_value);
			}
			seriesDataMap.put(cycle_value, value);
		}
		ArrayList<SeriesVo> seriesvos = new ArrayList<SeriesVo>();
		Set<Entry<String, LinkedHashMap<String, String>>> sets = seriesDataMap.entrySet();
		for (Entry<String, LinkedHashMap<String, String>> entry : sets) {
			SeriesVo svo = new SeriesVo();
			svo.setLegendCode(entry.getKey());
			svo.setLegendName(entry.getKey());
			LinkedHashMap<String, String> dataMaps = entry.getValue();
			Set<Entry<String, String>> dataMapsSet = dataMaps.entrySet();
			List<String> dataSets = new ArrayList<String>();
			for (Entry<String, String> entry2 : dataMapsSet) {
				dataSets.add(entry2.getValue());
			}
			svo.setData(dataSets);
			seriesvos.add(svo);
		}
		return seriesvos;
	}

	/**
	 * @param seriesData
	 * @param data
	 * @return
	 */
	public static ArrayList<SeriesVo> getLinSeriesVosByRep(Reponse data) {
		LinkedHashMap<String, LinkedHashMap<String, String>> seriesDataMap = new LinkedHashMap<String, LinkedHashMap<String, String>>(); // 所有的时间坐标
		Set<String> legendCodes = new LinkedHashSet<String>();

		Set<String> dic_codes = new LinkedHashSet<String>();
		if (null == data) {
			return null;
		}

		RepQuota quota = data.getQuota();
		if (null == quota) {
			return null;
		}

		List<RepDic> dics = quota.getDim().getDic();

		LinkedHashMap<String, String> value2 = new LinkedHashMap<String, String>();//新增  开户量排名图  legendcode 对应dicCode  lengendName 对应dicName
		for (RepDic repDic : dics) {
			legendCodes.addAll(getCycleValues(repDic.getDic_data_cycle().getCycle_data_set()));
			dic_codes.add(repDic.getDic_code());
			value2.put(repDic.getDic_code(), repDic.getDic_name());//新增
		}
		for (String dic_code : dic_codes) {

			LinkedHashMap<String, String> value = new LinkedHashMap<String, String>();
			for (String legendCode : legendCodes) {
				String data_value = getdataValueByCycleValueAndDicCode(legendCode, dic_code, dics);
				value.put(legendCode,
						StringUtil.isBlank(data_value) ? "0" : "null".equals(data_value) ? "0" : data_value);
			}
			seriesDataMap.put(dic_code, value);
		}
		ArrayList<SeriesVo> seriesvos = new ArrayList<SeriesVo>();
		Set<Entry<String, LinkedHashMap<String, String>>> sets = seriesDataMap.entrySet();
		for (Entry<String, LinkedHashMap<String, String>> entry : sets) {
			SeriesVo svo = new SeriesVo();
			svo.setLegendCode(entry.getKey());
			//svo.setLegendName(entry.getKey());
			svo.setLegendName(value2.get(entry.getKey()));
			LinkedHashMap<String, String> dataMaps = entry.getValue();
			Set<Entry<String, String>> dataMapsSet = dataMaps.entrySet();
			List<String> dataSets = new ArrayList<String>();
			for (Entry<String, String> entry2 : dataMapsSet) {
				dataSets.add(entry2.getValue());
			}
			svo.setData(dataSets);
			seriesvos.add(svo);
		}
		return seriesvos;
	}

	private static String getdataValueByCycleValueAndDicCode(String cycle_value, String dic_code, List<RepDic> dics) {
		for (RepDic repDic : dics) {
			if (dic_code.equals(repDic.getDic_code())) {
				List<CycleDataSet> cycle_data_set = repDic.getDic_data_cycle().getCycle_data_set();
				for (CycleDataSet cycleDataSet : cycle_data_set) {
					if (cycle_value.equals(cycleDataSet.getCycle_value())) {
					/*	return cycleDataSet.getData_set_row() == null ? "0"
								: cycleDataSet.getData_set_row().get(0) == null ? "0"
										: cycleDataSet.getData_set_row().get(0).getRow_data() == null ? "0"
												: cycleDataSet.getData_set_row().get(0).getRow_data().get(0) == null
														? "0"
														: cycleDataSet.getData_set_row().get(0).getRow_data().get(0)
																.getData_value();*/
						//将上述代码替换为下方代码，避免Data_set_row节点无内容造成的IndexOutOfBound...
						List<DataSetRow> data_set_rows = cycleDataSet.getData_set_row();
						if (!CollectionUtils.isEmpty(data_set_rows)) {
							List<RowData> row_datas = data_set_rows.get(0).getRow_data();
							if (!CollectionUtils.isEmpty(row_datas)) {
								return row_datas.get(0).getData_value();
							}
						}
					}
				}
			}
		}

		return null;
	}

	private static Set<String> getCycleValues(List<CycleDataSet> cycle_data_set) {
		Set<String> cycleValues = new LinkedHashSet<String>();
		if (CollectionUtils.isEmpty(cycle_data_set)) {
			return cycleValues;
		}
		for (CycleDataSet cycle_data : cycle_data_set) {
			if (StringUtil.isBlank(cycle_data.getCycle_value())) {
				continue;
			}
			cycleValues.add(cycle_data.getCycle_value());

		}
		return cycleValues;
	}

	/**
	 * 报文层级太深，用java对象解析太麻烦，性能也不好，所以直接用正则表达式解析；
	 * 
	 * @param data
	 * @return
	 */
	// public static ArrayList<SeriesVo> getSeriesVosByJson(String data) {
	// if (StringUtil.isBlank(data)) {
	// return null;
	// }
	// ArrayList<String> dataValues = getValuesByKey("data_value", "");
	// if (CollectionUtils.isEmpty(dataValues)) {
	// return null;
	// }
	// ArrayList<SeriesVo> seriesvos = new ArrayList<SeriesVo>();
	// for (String dataValue : dataValues) {
	// SeriesVo vo = new SeriesVo();
	// // vo.setData(data);
	// }
	// return seriesvos;
	// }

	// public static void main(String[] args) {
	// String jsondata = "";
	// Reader input = null;
	// StringBuffer sb = new StringBuffer();
	// try {
	// input = Resources.getResourceAsReader("all.json");
	// BufferedReader r = new BufferedReader(input);
	// String line;
	// while ((line = r.readLine()) != null) {
	// sb.append(line);
	// }
	// System.out.println("内容为：" + sb); // 把字符数组变为字符串输出
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// jsondata = sb.toString();
	// }
	// jsondata = JSON.toJSONString(JSON.parseObject(jsondata, Reponse.class));
	// System.out.println("jsondata内容为：" + jsondata); // 把字符数组变为字符串输出
	// getValuesByKey("data_value", jsondata);
	// }

	public static ArrayList<String> getValuesByKey(String key, String jsondata) {
		ArrayList<String> list = new ArrayList<String>();
		String regex = getRegex(key);
		Pattern patn = Pattern.compile(regex);
		Matcher m = patn.matcher(jsondata);
		while (m.find()) {
			if (StringUtil.isBlank(m.group(1))) {
				continue;
			}
			System.out.println(key + "=" + m.group(1));
			list.add(m.group(1));
		}
		return list;
	}

	public static String getRegex(String key) {
		return "^*\"" + key + "\":\"([^\"]*)\"*";
	}

	public static List<String> getBarSeriesDataByRep(Reponse rdata) {
		ArrayList<String> data = new ArrayList<String>();
		List<RepDic> dics = rdata.getQuota().getDim().getDic();
		for (RepDic repDic : dics) {
			data.add(repDic.getDic_code());
		}
		return data;
	}
	//新增  开户量排名图的x轴
	public static List<String> getSeriesAccountByRep(Reponse rdata) {
		ArrayList<String> data = new ArrayList<String>();
		List<RepDic> dics = rdata.getQuota().getDim().getDic();
		for (RepDic repDic : dics) {
			data.add(repDic.getDic_name());
		}
		return data;
	}

	public static List<String> getLinSeriesDataByRep(Reponse rdata) {
		ArrayList<String> data = new ArrayList<String>();
		Set<String> cycle_data_sets = new LinkedHashSet<String>();
		List<RepDic> dics = rdata.getQuota().getDim().getDic();
		for (RepDic repDic : dics) {
			List<CycleDataSet> cycle_data_set = repDic.getDic_data_cycle().getCycle_data_set();
			if (CollectionUtils.isEmpty(cycle_data_set)) {
				continue;
			}
			for (CycleDataSet cycleDataSet : cycle_data_set) {
				if (cycle_data_sets.contains(cycleDataSet.getCycle_value())) {
					continue;
				}
				cycle_data_sets.add(cycleDataSet.getCycle_value());
				data.add(cycleDataSet.getCycle_value());
			}
		}
		return data;
	}
	
	//新增 分时图坐标轴
	public static List<String> getLinSeriesDataByRepDic(RepDic repDic) {
		ArrayList<String> data = new ArrayList<String>();
		
		List<CycleDataSet> cycle_data_set = repDic.getDic_data_cycle().getCycle_data_set();
		if (!CollectionUtils.isEmpty(cycle_data_set)) {
			for (CycleDataSet cycleDataSet : cycle_data_set) {
				List<DataSetRow> data_set_rows = cycleDataSet.getData_set_row();
				if (!CollectionUtils.isEmpty(data_set_rows)) {
					for (DataSetRow dataSetRow : data_set_rows) {
						String interval = dataSetRow.getInterval();
						if (!data.contains(interval)) {
							data.add(interval);
						}
					}
				}
			}
		}
		//添加排序
		
		Collections.sort(data, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) {
					return 1;
				}else if (o1.length() < o2.length()) {
					return -1;
				}else {
					return o1.compareTo(o2);
				}
			}
		});
		return data;
	}

	//新增  用户量 x轴 数据
	public static List<String> getBarTopSeriesDataByRep(Reponse rdata, String id, String name) {
		
		ArrayList<String> data = new ArrayList<String>();
		List<RepDic> dics = rdata.getQuota().getDim().getDic();
		for (RepDic repDic : dics) {
			List<DataSetRow> data_set_rows = repDic.getDic_data_cycle().getCycle_data_set().get(0).getData_set_row();
			if (!CollectionUtils.isEmpty(data_set_rows)) {
				for (DataSetRow dataSetRow : data_set_rows) {
					String cs1 = "";
					String cs2 = "";
					List<RowData> row_datas = dataSetRow.getRow_data();
					if (!CollectionUtils.isEmpty(row_datas)) {
						for (RowData rowData : row_datas) {
							if (StringUtils.equals(id, rowData.getData_code())) {
								cs1 = rowData.getData_value();
							}
							if (StringUtils.equals(name, rowData.getData_code())) {
								cs2 = rowData.getData_value();
							}
						}
						data.add(cs1 + "," + cs2);
					}
				}
			}
		}
		return data;
	}

}
