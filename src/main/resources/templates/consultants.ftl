<#import '_main.ftl' as m>
<@m.page title="Consultants">
<div class="container">
    <div class="row">
        <div class="eight columns" style="margin-top: 30px">
            <h1>List of consultants</h1>
            <form action="/consultant/" method="POST">
                <input type="text" name="firstName" placeholder="firstName">
                <input type="text" name="lastName" placeholder="lastName">
                <input type="text" name="department" placeholder="department">
                <button type="submit" class="button-primary" onclick='mixpanel.track("feature consultant", {"action": "submit"})'>Create!</button>
            </form>
            <table style="width: 100%">
                <thead>
                    <tr>
                        <th>firstName</th>
                        <th>lastName</th>
                        <th>Department</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <#list consultants as c>
                    <tr>
                        <td>${c.firstName}</td>
                        <td>${c.lastName}</td>
                        <td>${c.department}</td>
                    </tr>
                    </#list>
                </tbody>
            </table>
            <#if !consultants?has_content>
            <div>
                Nothing to show! Yea! Go create a new consultant up there.
            </div>
            </#if>
        </div>
    </div>
</div>

</@m.page>