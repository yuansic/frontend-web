package com.frontend.web.model.chart.builder;

import java.util.ArrayList;
import java.util.List;

import com.frontend.web.model.chart.RankingData;
import com.frontend.web.model.chart.base.AbstractChart;
import com.frontend.web.model.chart.base.AbstractChartBuilder;
import com.frontend.web.model.chart.factor.RankElement;
import com.frontend.web.model.response.DataSetRow;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.model.response.RowData;

public class RankingDataBuilder extends AbstractChartBuilder {

	private static final String NAME = "NAME";

	private static final String TEXT = "TEXT";

	private static final String DATESTRING = "DATESTRING";

	@Override
	public AbstractChart build(Reponse rdata) {
		RankingData data = new RankingData();

		List<DataSetRow> data_set_row = rdata.getQuota().getDim().getDic().get(0).getDic_data_cycle()
				.getCycle_data_set().get(0).getData_set_row();

		List<RankElement> elements = new ArrayList<RankElement>();
		for (DataSetRow dataSetRow : data_set_row) {
			List<RowData> row_datas = dataSetRow.getRow_data();
			RankElement rankElement = new RankElement();
			rankElement.setSortIndex(dataSetRow.getRow_num());
			for (RowData rowData : row_datas) {
				if (NAME.equals(rowData.getData_code())) {
					rankElement.setName(rowData.getData_value());
				}
				if (TEXT.equals(rowData.getData_code())) {
					rankElement.setText(rowData.getData_value());
				}
				if (DATESTRING.equals(rowData.getData_code())) {
					rankElement.setDateString(rowData.getData_value());
				}
			}
			elements.add(rankElement);
		}
		data.setElements(elements);
		return data;
	}

	@Override
	public List<AbstractChart> builds(Reponse rdata) {
		return null;
	}

}
