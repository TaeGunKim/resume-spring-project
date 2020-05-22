package com.mycompany.myapp.common.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class PamaSiteMeshFilter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		// Map default decorator. This shall be applied to all paths if no other paths match.
		builder
				//.addDecoratorPath("/*", "/WEB-INF/jsp/decorators/front.jsp")
				// Map decorators to path patterns.
				.addDecoratorPath("/main.do", "/WEB-INF/jsp/decorators/front_main.jsp")
		        .addDecoratorPath("/login/loginOk.do", "/WEB-INF/jsp/decorators/front_main.jsp")
		        .addDecoratorPath("/login/*", "/WEB-INF/jsp/decorators/front_login.jsp")
		        .addDecoratorPath("/*", "/WEB-INF/jsp/decorators/front.jsp")
				.addExcludedPath("/media/*");
	}


}
