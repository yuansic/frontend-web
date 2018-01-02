package com.frontend.web.model.chart.builder;

import java.util.ArrayList;
import java.util.List;

import com.frontend.web.model.chart.RankingData;
import com.frontend.web.model.chart.base.AbstractChart;
import com.frontend.web.model.chart.base.AbstractChartBuilder;
import com.frontend.web.model.chart.factor.RankElement;
import com.frontend.web.model.response.DataSetRow;
import com.frontend.web.model.response.RepDic;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.model.response.RowData;
import com.frontend.web.utils.CollectionUtils;

/**
 * 地图数据转换
 * @author captain
 *
 */
public class MapBuilder extends AbstractChartBuilder {


	@Override
	public AbstractChart build(Reponse rdata) {
		RankingData data = new RankingData();

		List<RepDic> dics = rdata.getQuota().getDim().getDic();

		List<RankElement> elements = new ArrayList<RankElement>();
		for (RepDic repDic : dics) {
			
			RankElement rankElement = new RankElement();
			rankElement.setCode(repDic.getDic_code());
			rankElement.setName(repDic.getDic_name());
			rankElement.setSortIndex(0);
			List<DataSetRow> data_set_rows = repDic.getDic_data_cycle().getCycle_data_set().get(0).getData_set_row();
			String data_value = "0";
			if (!CollectionUtils.isEmpty(data_set_rows)) {
				List<RowData> row_datas = data_set_rows.get(0).getRow_data();
				if (!CollectionUtils.isEmpty(row_datas)) {
					data_value = row_datas.get(0).getData_value();
				}
			}
			//String data_value = repDic.getDic_data_cycle().getCycle_data_set().get(0).getData_set_row().get(0).getRow_data().get(0).getData_value();
			rankElement.setText(data_value);
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
