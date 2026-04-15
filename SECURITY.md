# SECURITY.md

Authentication is the process of verifying who a user is (for example, logging in with `user1` or `admin1`). Authorization is the process of deciding what that authenticated user is allowed to access (for example, whether they can open `/secure/admin`).

## Roles Used

- `USER`
- `ADMIN`

## Protected URLs

- `/secure/hello` -> `USER`, `ADMIN`
- `/secure/admin` -> `ADMIN` only

## How To Test

- Created users in Payara file realm:
  - `user1` in group `USER`
  - `admin1` in group `ADMIN`
- Context root used: `/lab4-rbac-security`
- Exact URLs tested:
  - `http://localhost:8080/lab4-rbac-security/secure/hello`
  - `http://localhost:8080/lab4-rbac-security/secure/admin`

## Expected Results

- Login as `user1` at `/secure/hello` -> allowed
- Login as `user1` at `/secure/admin` -> denied (`HTTP 403 Forbidden`)
- Login as `admin1` at `/secure/admin` -> allowed

Screenshot evidence for these test results is included in `README.md` under the "Sample Output Screenshot" section.
