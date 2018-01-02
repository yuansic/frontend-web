package com.frontend.web.model.chart.builder;

import java.util.ArrayList;
import java.util.List;

import com.frontend.web.model.chart.CommonChart;
import com.frontend.web.model.chart.base.AbstractChart;
import com.frontend.web.model.chart.base.AbstractChartBuilder;
import com.frontend.web.model.chart.factor.AxisVo;
import com.frontend.web.model.chart.factor.SeriesVo;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.utils.ReponseUtils;

/**
 * 柱状/条形图<br>
 *
 * @author knowAndDo
 *
 */
public class SeriesBarBuilder extends AbstractChartBuilder {

	/**
	 * xAxis.data取自dim.dic.dic_code集合<br>
	 * seriesData.legendCode取自dim.dic.dic_data_cycle.cycle_data_set.cycle_value<br>
	 * seriesData.legendName取自dim.dic.dic_data_cycle.cycle_data_set.cycle_value<br>
	 * seriesData.data取自dim.dic.dic_data_cycle.cycle_data_set.cycle_data_row.row_data.data_value<br>
	 */

	@Override
	public AbstractChart build(Reponse rdata) {
		CommonChart chart = new CommonChart();
		chart.setQuotaCode(rdata.getQuota().getQuota_code());
		chart.setRepcode(rdata.getRepcode());
		chart.setRepmsg(rdata.getRepmsg());
		chart.setTitle(rdata.getQuota().getQuota_name());
		List<SeriesVo> seriesData = ReponseUtils.getBarSeriesVosByRep(rdata);
		chart.setSeriesData(seriesData);
		AxisVo xAxis = new AxisVo();
		xAxis.setData(ReponseUtils.getBarSeriesDataByRep(rdata));
		chart.setxAxis(xAxis);
		List<AxisVo> yAxis = new ArrayList<AxisVo>();
		chart.setyAxis(yAxis);
		return chart;
	}

	@Override
	public List<AbstractChart> builds(Reponse rdata) {
		// TODO Auto-generated method stub
		return null;
	}

}
