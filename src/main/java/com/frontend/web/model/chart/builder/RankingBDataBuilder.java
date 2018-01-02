package com.frontend.web.model.chart.builder;

import java.util.ArrayList;
import java.util.List;

import com.frontend.web.model.chart.PercentChart;
import com.frontend.web.model.chart.base.AbstractChart;
import com.frontend.web.model.chart.base.AbstractChartBuilder;
import com.frontend.web.model.response.DataSetRow;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.model.response.RowData;

public class RankingBDataBuilder extends AbstractChartBuilder {

	private static final String POINT_ID = "POINT_ID";

	private static final String PERCENT = "PERCENT";

	@Override
	public AbstractChart build(Reponse rdata) {
		return null;
	}

	@Override
	public List<PercentChart> builds(Reponse rdata) {
		List<PercentChart> charts = new ArrayList<PercentChart>();
		List<DataSetRow> data_set_rows = rdata.getQuota().getDim().getDic().get(0).getDic_data_cycle()
				.getCycle_data_set().get(0).getData_set_row();
		for (DataSetRow dataSetRow : data_set_rows) {
			List<RowData> row_datas = dataSetRow.getRow_data();
			PercentChart chart = new PercentChart();
			chart.setSortIndex(Integer.valueOf(dataSetRow.getRow_num()).toString());
			for (RowData rowData : row_datas) {
				if (POINT_ID.equals(rowData.getData_code())) {
					chart.setFactorCode(rowData.getData_value());
					chart.setFactorName(rowData.getData_value());
				}
				if (PERCENT.equals(rowData.getData_code())) {
					chart.setPercentage(rowData.getData_value());
				}

			}
			charts.add(chart);
		}
		return charts;
	}

}
