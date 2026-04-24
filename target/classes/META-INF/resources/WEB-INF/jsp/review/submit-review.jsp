<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <div class="premium-card">
            <h2 class="mb-4 text-center">Add System Note</h2>
            
            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>

            <form action="/reviews/submit" method="POST">
                
                <div class="mb-3">
                    <label class="form-label fw-bold">Customer</label>
                    <select name="customerId" class="form-select" required>
                        <option value="" disabled selected>Select associated customer</option>
                        <c:forEach var="c" items="${customers}">
                            <option value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="mb-3">
                    <label class="form-label fw-bold">Vehicle</label>
                    <select name="vehicleId" class="form-select" required>
                        <option value="" disabled selected>Select vehicle</option>
                        <c:forEach var="v" items="${vehicles}">
                            <option value="${v.id}">${v.brand} ${v.model}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-4">
                    <label class="form-label fw-bold">Remarks / Internal Logs</label>
                    <textarea name="comment" class="form-control" rows="4" placeholder="Enter details about the vehicle or customer..." required></textarea>
                </div>

                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary btn-lg fw-bold">Save Note</button>
                    <a href="/reviews/list" class="btn btn-outline-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
