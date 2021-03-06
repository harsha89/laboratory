/**
 *  Copyright 2011 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of Laboratory module.
 *
 *  Laboratory module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  Laboratory module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Laboratory module.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/

package org.openmrs.module.laboratory.db;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Order;
import org.openmrs.OrderType;
import org.openmrs.Patient;
import org.openmrs.Role;
import org.openmrs.module.hospitalcore.model.Lab;
import org.openmrs.module.hospitalcore.model.LabTest;

public interface LaboratoryDAO {

	/**
	 * Save radiology department
	 * 
	 * @param department
	 * @return
	 */
	public Lab saveLaboratoryDepartment(Lab department);

	/**
	 * Get radiology department by id
	 * 
	 * @param id
	 * @return
	 */
	public Lab getLaboratoryDepartment(Integer id);

	/**
	 * Delete a radiology department
	 * 
	 * @param department
	 */
	public void deleteLabDepartment(Lab department);

	/**
	 * Get radiology department by role
	 * 
	 * @param role
	 * @return
	 */
	public Lab getDepartment(Role role);

	/**
	 * Find orders
	 * 
	 * @param orderStartDate
	 * @param orderType
	 * @param tests
	 * @param patients
	 * @param page
	 * @return
	 * @throws ParseException
	 */
	public List<Order> getOrders(Date orderStartDate, OrderType orderType,
			Set<Concept> tests, List<Patient> patients, int page)
			throws ParseException;

	/**
	 * Count the number of found orders
	 * 
	 * @param orderStartDate
	 * @param orderType
	 * @param tests
	 * @param patients
	 * @param page
	 * @return
	 * @throws ParseException
	 */
	public Integer countOrders(Date orderStartDate, OrderType orderType,
			Set<Concept> tests, List<Patient> patients) throws ParseException;

	/**
	 * Save radiology test
	 * 
	 * @param test
	 * @return
	 */
	public LabTest saveLaboratoryTest(LabTest test);

	/**
	 * Get radiology test by id
	 * 
	 * @param id
	 * @return
	 */
	public LabTest getLaboratoryTest(Integer id);

	/**
	 * Delete a radiology test *
	 * 
	 * @param test
	 */
	public void deleteLaboratoryTest(LabTest test);

	/**
	 * Get radiology test by order
	 * 
	 * @param order
	 * @return
	 */
	public LabTest getLaboratoryTest(Order order);

	/**
	 * Get radiology tests
	 * 
	 * @param date
	 * @param status
	 * @param concepts
	 * @return
	 * @throws ParseException
	 */
	public List<LabTest> getLaboratoryTests(Date date, String status,
			Set<Concept> concepts, List<Patient> patients)
			throws ParseException;

	/**
	 * Get radiology tets by date
	 * 
	 * @param date
	 * @param tests
	 *            TODO
	 * @param patients
	 *            TODO
	 * @return
	 * @throws ParseException
	 */
	public abstract List<LabTest> getLaboratoryTestsByDate(Date date,
			Set<Concept> tests, List<Patient> patients) throws ParseException;

	/**
	 * Get radiology tests by discontinued date
	 * 
	 * @param date
	 * @param tests
	 *            TODO
	 * @param patients
	 *            TODO
	 * @return
	 * @throws ParseException
	 */
	public List<LabTest> getLaboratoryTestsByDiscontinuedDate(Date date,
			Set<Concept> tests, List<Patient> patients) throws ParseException;

	/**
	 * Get radiology test by date and patient
	 * 
	 * @param date
	 * @param patient
	 * @return
	 * @throws ParseException
	 */
	public List<LabTest> getLaboratoryTestsByDateAndPatient(Date date,
			Patient patient) throws ParseException;

	/**
	 * Get laboratory tests
	 * 
	 * @param date
	 * @param sampleId
	 *            TODO
	 * @return
	 * @throws ParseException
	 */
	public List<LabTest> getLaboratoryTests(Date date, String sampleId)
			throws ParseException;

	/**
	 * Get order by patient, date, and concept
	 * 
	 * @param patient
	 * @param date
	 * @param concept
	 * @return
	 * @throws ParseException
	 */
	public List<Order> getOrders(Patient patient, Date date, Concept concept)
			throws ParseException;

	/**
	 * Get test by encounter
	 * 
	 * @param encounter
	 * @return
	 */
	public LabTest getLaboratoryTest(Encounter encounter);
	
	public List<LabTest> getAllTest();
}
