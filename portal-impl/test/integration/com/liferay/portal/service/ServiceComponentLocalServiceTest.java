/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.service;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.model.ServiceComponent;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.MainServletTestRule;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Alberto Chaparro
 */
public class ServiceComponentLocalServiceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), MainServletTestRule.INSTANCE);

	@Before
	public void setUp() {
		_previousServiceComponentsCount =
			ServiceComponentLocalServiceUtil.getServiceComponentsCount();

		_serviceComponentA = addServiceComponent(_SERVICE_COMPONENT_A, 1);
		_serviceComponentB = addServiceComponent(_SERVICE_COMPONENT_B, 1);
	}

	@Test
	public void testGetLatestServiceComponentsSingleVersion() throws Exception {
		List<ServiceComponent> serviceComponents =
			ServiceComponentLocalServiceUtil.
				getLatestServiceComponentsByBuildNamespace();

		Assert.assertEquals(
			2, serviceComponents.size() - _previousServiceComponentsCount);

		ServiceComponent latestServiceComponent = getServiceComponent(
			serviceComponents, _SERVICE_COMPONENT_A);

		Assert.assertEquals(1, latestServiceComponent.getBuildNumber());

		latestServiceComponent = getServiceComponent(
			serviceComponents, _SERVICE_COMPONENT_B);

		Assert.assertEquals(1, latestServiceComponent.getBuildNumber());
	}

	@Test
	public void testGetLatestServiceComponentsWithMultipleVersions()
		throws Exception {

		ServiceComponent serviceComponent = addServiceComponent(
			_SERVICE_COMPONENT_A, 2);

		List<ServiceComponent> serviceComponents =
			ServiceComponentLocalServiceUtil.
				getLatestServiceComponentsByBuildNamespace();

		Assert.assertEquals(
			2, serviceComponents.size() - _previousServiceComponentsCount);

		ServiceComponent latestServiceComponent = getServiceComponent(
			serviceComponents, _SERVICE_COMPONENT_A);

		Assert.assertEquals(2, latestServiceComponent.getBuildNumber());

		latestServiceComponent = getServiceComponent(
			serviceComponents, _SERVICE_COMPONENT_B);

		Assert.assertEquals(1, latestServiceComponent.getBuildNumber());

		ServiceComponentLocalServiceUtil.deleteServiceComponent(
			serviceComponent);
	}

	protected ServiceComponent addServiceComponent(
		String buildNameSpace, long buildNumber) {

		long serviceComponentId = CounterLocalServiceUtil.increment();

		ServiceComponent serviceComponent =
			ServiceComponentLocalServiceUtil.createServiceComponent(
				serviceComponentId);

		serviceComponent.setBuildNamespace(buildNameSpace);
		serviceComponent.setBuildNumber(buildNumber);

		return ServiceComponentLocalServiceUtil.updateServiceComponent(
			serviceComponent);
	}

	protected ServiceComponent getServiceComponent(
		List<ServiceComponent> serviceComponents, String buildNamespace) {

		for (ServiceComponent serviceComponent : serviceComponents) {
			String currentBuildNamespace = serviceComponent.getBuildNamespace();

			if (currentBuildNamespace.equals(buildNamespace)) {
				return serviceComponent;
			}
		}

		return null;
	}

	private static final String _SERVICE_COMPONENT_A = "serviceComponentA";

	private static final String _SERVICE_COMPONENT_B = "serviceComponentB";

	private int _previousServiceComponentsCount;

	@DeleteAfterTestRun
	private ServiceComponent _serviceComponentA;

	@DeleteAfterTestRun
	private ServiceComponent _serviceComponentB;

}