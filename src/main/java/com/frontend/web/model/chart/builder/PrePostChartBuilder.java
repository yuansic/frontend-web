package com.frontend.web.model.chart.builder;

import java.util.ArrayList;
import java.util.List;

import com.frontend.web.model.chart.RankingData;
import com.frontend.web.model.chart.base.AbstractChart;
import com.frontend.web.model.chart.base.AbstractChartBuilder;
import com.frontend.web.model.chart.factor.RankElement;
import com.frontend.web.model.response.CycleDataSet;
import com.frontend.web.model.response.DataSetRow;
import com.frontend.web.model.response.RepDic;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.model.response.RowData;
import com.frontend.web.utils.CollectionUtils;

/**
 * 预付后付
 * 
 * @author captain
 *
 */
public class PrePostChartBuilder extends AbstractChartBuilder {
	
	private static final String PRE = "PRE_USR_CNT";
	private static final String POST = "POST_USR_CNT";

	@Override
	public AbstractChart build(Reponse rdata) {
		RankingData chart = new RankingData();
		List<RankElement> elements = new ArrayList<RankElement>();
		List<RepDic> dics = rdata.getQuota().getDim().getDic();
		for (RepDic repDic : dics) {
			List<CycleDataSet> cycle_data_sets = repDic.getDic_data_cycle().getCycle_data_set();
			if (!CollectionUtils.isEmpty(cycle_data_sets)) {
				List<DataSetRow> data_set_rows = cycle_data_sets.get(0).getData_set_row();
				if (!CollectionUtils.isEmpty(data_set_rows)) {
					List<RowData> row_datas = data_set_rows.get(0).getRow_data();
					if (!CollectionUtils.isEmpty(row_datas)) {
						for (RowData rowData : row_datas) {
							String data_code = rowData.getData_code();
							RankElement rankElement = new RankElement();
							rankElement.setCode(data_code);
							if (PRE.equals(data_code)) {
								rankElement.setName("预付费");
							}
							if (POST.equals(data_code)) {
								rankElement.setName("后付费");
							}
							rankElement.setSortIndex(0);
							rankElement.setText(rowData.getData_value());
							rankElement.setParentCode(repDic.getDic_code());
							rankElement.setParentName(repDic.getDic_name());
							elements.add(rankElement);
						}
					}
				}
			}
		}
		chart.setElements(elements);
		return chart;
	}

	@Override
	public List<? extends AbstractChart> builds(Reponse rdata) {
		// TODO Auto-generated method stub
		return null;
	}


}
