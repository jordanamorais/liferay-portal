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

package com.liferay.headless.collaboration.internal.resource;

import com.liferay.headless.collaboration.resource.ImageObjectRepositoryResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Javier Gamarra
 */
@Component(
	property = {
		"api.version=1.0.0",
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=headless-collaboration-application.rest)", "osgi.jaxrs.resource=true"
	},
	scope = ServiceScope.PROTOTYPE, service = ImageObjectRepositoryResource.class
)
public class ImageObjectRepositoryResourceImpl
	extends BaseImageObjectRepositoryResourceImpl {
}