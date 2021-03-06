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

package com.liferay.headless.web.experience.resource.v1_0;

import com.liferay.headless.web.experience.dto.v1_0.AggregateRating;
import com.liferay.headless.web.experience.dto.v1_0.Comment;
import com.liferay.headless.web.experience.dto.v1_0.ContentDocument;
import com.liferay.headless.web.experience.dto.v1_0.ContentStructure;
import com.liferay.headless.web.experience.dto.v1_0.Creator;
import com.liferay.headless.web.experience.dto.v1_0.StructuredContent;
import com.liferay.oauth2.provider.scope.RequiresScope;
import com.liferay.portal.vulcan.context.Pagination;
import com.liferay.portal.vulcan.dto.Page;

import java.util.Date;

import javax.annotation.Generated;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/headless-web-experience/v1.0
 *
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
@Path("/v1.0")
public interface StructuredContentResource {

	@GET
	@Path("/content-space/{content-space-id}/structured-contents")
	@Produces("application/json")
	@RequiresScope("headless-web-experience-application.read")
	public Page<StructuredContent> getContentSpaceStructuredContentsPage( @PathParam("content-space-id") Long contentSpaceId , @QueryParam("filter") String filter , @QueryParam("sort") String sort , @Context Pagination pagination ) throws Exception;

	@Consumes("application/json")
	@POST
	@Path("/content-space/{content-space-id}/structured-contents")
	@Produces("application/json")
	@RequiresScope("headless-web-experience-application.read")
	public StructuredContent postContentSpaceStructuredContent( @PathParam("content-space-id") Long contentSpaceId , StructuredContent structuredContent ) throws Exception;

	@Consumes("application/json")
	@POST
	@Path("/content-space/{content-space-id}/structured-contents/batch-create")
	@Produces("application/json")
	@RequiresScope("headless-web-experience-application.write")
	public StructuredContent postContentSpaceStructuredContentsBatchCreate( @PathParam("content-space-id") Long contentSpaceId , StructuredContent structuredContent ) throws Exception;

	@GET
	@Path("/structured-contents/{structured-contents-id}")
	@Produces("application/json")
	@RequiresScope("headless-web-experience-application.read")
	public StructuredContent getStructuredContent( @PathParam("structured-contents-id") Long structuredContentsId ) throws Exception;

	@Consumes("application/json")
	@PUT
	@Path("/structured-contents/{structured-contents-id}")
	@Produces("application/json")
	@RequiresScope("headless-web-experience-application.read")
	public StructuredContent putStructuredContent( @PathParam("structured-contents-id") Long structuredContentsId , StructuredContent structuredContent ) throws Exception;

}