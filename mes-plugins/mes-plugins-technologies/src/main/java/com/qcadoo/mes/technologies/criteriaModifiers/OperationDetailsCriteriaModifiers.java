/**
 * ***************************************************************************
 * Copyright (c) 2018 RiceFish Limited
 * Project: SmartMES
 * Version: 1.6
 *
 * This file is part of SmartMES.
 *
 * SmartMES is Authorized software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * ***************************************************************************
 */
package com.qcadoo.mes.technologies.criteriaModifiers;

import org.springframework.stereotype.Service;

import com.qcadoo.mes.technologies.constants.OperationFields;
import com.qcadoo.model.api.search.JoinType;
import com.qcadoo.model.api.search.SearchCriteriaBuilder;
import com.qcadoo.model.api.search.SearchRestrictions;
import com.qcadoo.view.api.components.lookup.FilterValueHolder;

@Service
public class OperationDetailsCriteriaModifiers {

    public void showProductionLinesForDivision(final SearchCriteriaBuilder scb, final FilterValueHolder filterValue) {
    }

    public void showWorkstationsForProductionLine(final SearchCriteriaBuilder scb, final FilterValueHolder filterValue) {
        if (filterValue.has(OperationFields.PRODUCTION_LINE)) {
            Long productionLineId = filterValue.getLong(OperationFields.PRODUCTION_LINE);
            scb.createAlias(OperationFields.PRODUCTION_LINE, OperationFields.PRODUCTION_LINE, JoinType.INNER).add(
                    SearchRestrictions.eq(OperationFields.PRODUCTION_LINE + ".id", productionLineId));
        }
    }

}
