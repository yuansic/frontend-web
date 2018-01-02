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
 * 柱状/条形图,Y轴模式<br>
 *
 * @author knowAndDo
 *
 */
public class SeriesBarYBuilder extends AbstractChartBuilder {

	@Override
	public AbstractChart build(Reponse rdata) {
	
		CommonChart chart = new CommonChart();
		chart.setQuotaCode(rdata.getQuota().getQuota_code());
		chart.setRepcode(rdata.getRepcode());
		chart.setRepmsg(rdata.getRepmsg());
		chart.setTitle(rdata.getQuota().getQuota_name());
		List<SeriesVo> seriesData = ReponseUtils.getBarYSeriesVosByRep(rdata);
		chart.setSeriesData(seriesData);
		AxisVo yAxis = new AxisVo();
		yAxis.setData(ReponseUtils.getBarSeriesDataByRep(rdata));
		List<AxisVo> yAxiss = new ArrayList<AxisVo>();
		yAxiss.add(yAxis);
		chart.setyAxis(yAxiss);
		return chart;
	}

	@Override
	public List<AbstractChart> builds(Reponse rdata) {
		// TODO Auto-generated method stub
		return null;
	}

}
