package com.frontend.web.model.chart.builder;

import java.util.ArrayList;
import java.util.List;

import com.frontend.web.model.chart.PercentChart;
import com.frontend.web.model.chart.base.AbstractChart;
import com.frontend.web.model.chart.base.AbstractChartBuilder;
import com.frontend.web.model.response.CycleDataSet;
import com.frontend.web.model.response.DataSetRow;
import com.frontend.web.model.response.RepDic;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.model.response.RowData;
import com.frontend.web.utils.CollectionUtils;
import com.frontend.web.utils.StringUtil;

/**
 * 进度条
 * 
 * @author knowAndDo
 *
 */
public class SeriesLinProcessChartBuilder extends AbstractChartBuilder {

	@Override
	public AbstractChart build(Reponse rdata) {
		return null;
	}

	@Override
	public List<PercentChart> builds(Reponse rdata) {

		List<PercentChart> charts = new ArrayList<PercentChart>();
		List<RepDic> dics = rdata.getQuota().getDim().getDic();
		for (RepDic repDic : dics) {
			PercentChart chart = new PercentChart();
			chart.setQuotaCode(rdata.getQuota().getQuota_code());
			chart.setRepcode(rdata.getRepcode());
			chart.setRepmsg(rdata.getRepmsg());
			chart.setTitle(rdata.getQuota().getQuota_name());
			chart.setDicCode(repDic.getDic_code());
			List<CycleDataSet> cycle_data_sets = repDic.getDic_data_cycle().getCycle_data_set();
			String data = "";
			if (!CollectionUtils.isEmpty(cycle_data_sets)) {
				List<DataSetRow> data_set_rows = cycle_data_sets.get(0).getData_set_row();
				if (!CollectionUtils.isEmpty(data_set_rows)) {
					List<RowData> row_datas = data_set_rows.get(0).getRow_data();
					if (!CollectionUtils.isEmpty(row_datas)) {
						data = row_datas.get(0).getData_value();
					}
				}
			}
			chart.setData(StringUtil.isBlank(data) ? "" : data);
			charts.add(chart);
		}

		return charts;
	}

}
