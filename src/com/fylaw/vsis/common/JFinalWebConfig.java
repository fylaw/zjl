package com.fylaw.vsis.common;

import com.fylaw.vsis.controller.YearController;
import com.fylaw.vsis.util.ConfigUtil;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.activerecord.tx.TxByActionMethods;
import com.jfinal.plugin.activerecord.tx.TxByRegex;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;

public class JFinalWebConfig extends JFinalConfig {

	/**
	 * ���ó���
	 */
	public void configConstant(Constants me) {
		// ���������ļ� ��̬��hashmap��
		ConfigUtil.loadConfig(loadPropertyFile("web_config.properties"));
		me.setDevMode(getPropertyToBoolean("devMode", false));
		me.setViewType(ViewType.FREE_MARKER);
		me.setBaseViewPath("/WEB-INF/pages");
		me.setError404View("/WEB-INF/pages/error/404.jsp");
		me.setError500View("/WEB-INF/pages/error/500.jsp");
	}

	/**
	 * ����·��
	 */
	public void configRoute(Routes me) {
		me.add("year", YearController.class);
//		me.add("InformationRetrieval", InformationRetrievalController.class);
//		me.add("MonitoringApplication", MonitoringApplicationController.class);
//		me.add("SelfservicenetWorkScanning", SelfservicenetWorkScanningController.class);
//		me.add("UserCenter", UserCenterController.class);
//		me.add("Announcement", AnnouncementController.class);
//		me.add("IndustryNews", IndustryNewsController.class);
//		me.add("Infringingtrackbriefing", InfringingtrackbriefingController.class);
//		me.add("Registeredworks", RegisteredworksController.class);
	}

	/**
	 * ���ò��
	 */
	public void configPlugin(Plugins me) {
		// ����C3p0���ݿ����ӳز��
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
		c3p0Plugin.setDriverClass(getProperty("driverClass"));
		me.add(c3p0Plugin);

		// ����ActiveRecord���
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin).setShowSql(true);
		me.add(arp);

		// ����Oracle����
		arp.setDialect(new OracleDialect());
		// ����������(�ֶ���)��Сд��������������
		arp.setContainerFactory(new CaseInsensitiveContainerFactory(false));

		// ����EhCache���
		me.add(new EhCachePlugin());

		// ��ӱ�ƥ��
//		arp.addMapping(Options.TABLE_NAME, Options.ID, Options.class);
//		arp.addMapping(WebRegisterUsers.TABLE_NAME, WebRegisterUsers.USER_ID, WebRegisterUsers.class);
//		arp.addMapping(WebBook.TABLE_NAME, WebBook.ID, WebBook.class);
//		arp.addMapping(WebBookUsers.TABLE_NAME, WebBookUsers.USER_ID, WebBookUsers.class);
//		arp.addMapping(WebBookRight.TABLE_NAME, WebBookRight.ID, WebBookRight.class);
//		arp.addMapping(TmpMonitoringApplyInfo.TABLE_NAME, TmpMonitoringApplyInfo.ID, TmpMonitoringApplyInfo.class);
//		arp.addMapping(TmpMonitoringReason.TABLE_NAME, TmpMonitoringReason.ID, TmpMonitoringReason.class);
//		arp.addMapping(TmpMonitoringReport.TABLE_NAME, TmpMonitoringReport.ID, TmpMonitoringReport.class);
//		arp.addMapping(TmpMonitoringReasonDetail.TABLE_NAME, TmpMonitoringReasonDetail.ID, TmpMonitoringReasonDetail.class);
//		arp.addMapping(TmpMonitoringReportDetail.TABLE_NAME, TmpMonitoringReportDetail.ID, TmpMonitoringReportDetail.class);
//		arp.addMapping(TmpBookSelfset.TABLE_NAME, TmpBookSelfset.ID, TmpBookSelfset.class);
//		arp.addMapping(TmpWebsiteSelfset.TABLE_NAME, TmpWebsiteSelfset.ID, TmpWebsiteSelfset.class);
//		arp.addMapping(TmpScanBtachSelfset.TABLE_NAME, TmpScanBtachSelfset.ID, TmpScanBtachSelfset.class);
//		arp.addMapping(TmpMonitoringReportMetadata.TABLE_NAME, TmpMonitoringReportMetadata.ID, TmpMonitoringReportMetadata.class);
//		arp.addMapping(TmpMonitoringReportIdentifier.TABLE_NAME, TmpMonitoringReportIdentifier.ID, TmpMonitoringReportIdentifier.class);
//		arp.addMapping(TmpMonitoringReportContent.TABLE_NAME, TmpMonitoringReportContent.ID, TmpMonitoringReportContent.class);
//		arp.addMapping(TmpMonitoringReportAuthorization.TABLE_NAME, TmpMonitoringReportAuthorization.ID, TmpMonitoringReportAuthorization.class);
//		arp.addMapping(TmpBookFavorites.TABLE_NAME, TmpBookFavorites.ID, TmpBookFavorites.class);
//		arp.addMapping(TmpMonitoringReportIdentifierResult.TABLE_NAME, TmpMonitoringReportIdentifierResult.ID, TmpMonitoringReportIdentifierResult.class);
//		arp.addMapping(TmpMonitoringReportContentResult.TABLE_NAME, TmpMonitoringReportContentResult.ID, TmpMonitoringReportContentResult.class);
//		arp.addMapping(TmpMonitoringReportTracking.TABLE_NAME, TmpMonitoringReportTracking.ID, TmpMonitoringReportTracking.class);
//		arp.addMapping(TmpMonitoringReportEvidenceCollection.TABLE_NAME, TmpMonitoringReportEvidenceCollection.ID, TmpMonitoringReportEvidenceCollection.class);
//		arp.addMapping(TmpWebNews.TABLE_NAME, TmpWebNews.ID, TmpWebNews.class);
//		arp.addMapping(InfringingRecord.TABLE_NAME, InfringingRecord.ID, InfringingRecord.class);
//		arp.addMapping(Lawsuit.TABLE_NAME, Lawsuit.ID, Lawsuit.class);

	}

	/**
	 * ���ô�����
	 */
	public void configHandler(Handlers me) {

	}

	/**
	 * ����ȫ��������
	 */
	public void configInterceptor(Interceptors me) {
		// ����������
//		me.add(new CookieAutoLoginInterceptor());
//		me.add(new SessionInterceptor());
//		me.add(new OptionsInterceptor());

		// ��������
		me.add(new TxByRegex(".*/((save)|(update)|(delete)).*"));
		me.add(new TxByActionMethods("save", "update", "delete"));
	}

	/**
	 * JFinal����������ص�
	 */
	public void afterJFinalStart() {
	}

	/**
	 * JFinal����ֹͣǰ�ص�
	 */
	public void beforeJFinalStop() {
	}

	/**
	 * ����ʹ�� JFinal �ֲ��Ƽ��ķ�ʽ������Ŀ ���д� main
	 * ��������������Ŀ����main�������Է����������Class�ඨ���У���һ��Ҫ���ڴ�
	 */
	public static void main(String[] args) {
		String webAppDir = JFinalWebConfig.class.getResource("/").getPath()
				.replace("/WEB-INF/classes/", "");
		System.out.println(webAppDir);
		JFinal.start(webAppDir, 80, "/", 5);
	}
}
